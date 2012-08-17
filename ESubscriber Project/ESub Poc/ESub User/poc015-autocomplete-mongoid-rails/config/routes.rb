Poc015AutocompleteMongoidRails::Application.routes.draw do
  resources :brands

  get "welcome/showrails"

  get "welcome/g"

  get "welcome/controller"

  get "welcome/welcome"

  get "welcome/show"

  get 'welcome/autocomplete_brand_name'

  root :to => "welcome#show"
end
