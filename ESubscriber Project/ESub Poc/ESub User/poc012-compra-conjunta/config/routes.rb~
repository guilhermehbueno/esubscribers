Poc012CompraConjunta::Application.routes.draw do
  get "welcome/index"

  match 'auth/:provider/callback', to: 'sessions#create'
  match 'auth/failure', to: redirect('/')
  match 'signout', to: 'sessions#destroy', as: 'signout'
  root to: 'welcome#index'
end
