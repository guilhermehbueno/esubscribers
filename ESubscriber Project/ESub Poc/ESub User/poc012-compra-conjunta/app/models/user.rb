class User
  include Mongoid::Document
  field :provider, type: String
  field :uid, type: String
  field :name, type: String
  field :oauth_token, type: String
  field :oauth_expires_at, type: Time


	def self.from_omniauth(auth)
	  user = find_or_create_by(uid: auth.uid) 
          user.name = auth.info.name
	  user.oauth_token = auth.credentials.token 			
	  user.oauth_expires_at = Time.at(auth.credentials.expires_at)	
	  user.save!
	  return user
	end
end
