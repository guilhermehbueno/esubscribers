class WelcomeController < ApplicationController
  def index

  end


  def autocomplete_friend_name
	if current_user
	    iniciar_por = params[:name_startsWith]
	    puts "Buscando por: #{iniciar_por}"
	    @friends =  current_user.friends.find_by_name(iniciar_por)
	    puts "Executando autocomplete_brand_name: #{@friends}"
	    render :json => @friends
	end
  end
end
