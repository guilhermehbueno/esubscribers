class Author
  include Mongoid::Document
  field :name
  #key :name
  has_many :articles
end