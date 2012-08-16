class Friend < ActiveRecord::Base
  attr_accessible :facebook_id, :name, :user

  belongs_to :user
end
