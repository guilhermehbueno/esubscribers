class WelcomeController < ApplicationController

  #autocomplete :Brand, :name


  def showrails
  end

  def g
  end

  def controller
  end

  def welcome
  end

  def show
  end

  def autocomplete_brand_name
    iniciar_por = params[:name_startsWith]
    puts "Buscando por: #{iniciar_por}"
    @brand = Brand.where(name: iniciar_por)
    puts "Executando autocomplete_brand_name: #{@brand}"
    render :json => @brand
  end

end
