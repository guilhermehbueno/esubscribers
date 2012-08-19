# Load the rails application
require File.expand_path('../application', __FILE__)

ENV['FACEBOOK_APP_ID'] = "132464260231342"
ENV['FACEBOOK_SECRET'] = "b7bf0a15ddb900e2bbabd549f4df9fd0"

# Initialize the rails application
Poc012CompraConjunta::Application.initialize!
