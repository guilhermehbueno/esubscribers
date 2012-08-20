class User
	include Mongoid::Document
	field :provider, type: String
	field :uid, type: String
	field :name, type: String
	field :oauth_token, type: String
	field :oauth_expires_at, type: Time

	
	embeds_many :friends do
	    def find_by_name(name)
	      puts "Procurando pelo Friend: #{name}"
	      retorno = where(name: /.*#{name}.*/)
	      puts "Quantidade retornada: #{retorno.count}"
	      retorno
	    end
	end

	def self.from_omniauth(auth)
	  user = find_or_create_by(uid: auth.uid) 
          user.name = auth.info.name
	  user.oauth_token = auth.credentials.token 			
	  user.oauth_expires_at = Time.at(auth.credentials.expires_at)	

	  @graph = Koala::Facebook::API.new(user.oauth_token)
	  @friends = @graph.get_connections("me", "friends")

	  for friend in @friends
		amigo = user.friends.find_or_create_by(id_social: friend["id"])
		amigo.name = friend["name"] 
		amigo.save!
	  end
	  user.save!
	  return user
	end
end
