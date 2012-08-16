class WelcomeController < ApplicationController
	def index
		@user = current_user
		if @user
			@graph = Koala::Facebook::API.new(@user.oauth_token)
			@friends = @graph.get_connections("me", "friends")
		end
	end
end