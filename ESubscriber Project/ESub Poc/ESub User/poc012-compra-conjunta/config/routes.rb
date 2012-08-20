Poc012CompraConjunta::Application.routes.draw do
  get "welcome/index"

  get 'welcome/autocomplete_friend_name'

  match 'auth/:provider/callback', to: 'sessions#create'
  match 'auth/failure', to: redirect('/')
  match 'signout', to: 'sessions#destroy', as: 'signout'
  root to: 'welcome#index'
end
