class Friend
  include Mongoid::Document
  field :id_social, type: String
  field :name, type: String

  embedded_in :user, :inverse_of => :friends
end
