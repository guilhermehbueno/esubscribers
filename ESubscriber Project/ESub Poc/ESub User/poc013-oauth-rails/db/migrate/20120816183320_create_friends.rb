class CreateFriends < ActiveRecord::Migration
  def change
    create_table :friends do |t|
      t.string :facebook_id
      t.string :name
      t.integer :user

      t.timestamps
    end
  end
end
