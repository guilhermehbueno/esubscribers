class WelcomeController < ApplicationController
	def index
		@user = current_user
		if @user
			@graph = Koala::Facebook::API.new(@user.oauth_token)
			@friends = @graph.get_connections("me", "friends")

			for friend in @friends
				amigo = Friend.new
				amigo.facebook_id = friend["id"]
				amigo.name =  friend["name"]
				amigo.user = @user
				amigo.save!
			end
		end
	end
end