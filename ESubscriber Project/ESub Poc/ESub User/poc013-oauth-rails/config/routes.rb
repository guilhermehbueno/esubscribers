Poc013OauthRails::Application.routes.draw do
  
  match 'auth/:provider/callback', to: 'sessions#create'
  match 'auth/failure', to: redirect('/')
  match 'signout', to: 'sessions#destroy', as: 'signout'

  resources :welcome
  resources :sessions
  root to: 'welcome#index'
end
