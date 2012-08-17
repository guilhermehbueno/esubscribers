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
    @brand = Brand.each
    puts "Executando autocomplete_brand_name"
    render :json => @brand
  end

end
