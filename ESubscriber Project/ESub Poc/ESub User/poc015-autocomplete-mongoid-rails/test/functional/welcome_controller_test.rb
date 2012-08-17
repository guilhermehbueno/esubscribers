require 'test_helper'

class WelcomeControllerTest < ActionController::TestCase
  test "should get showrails" do
    get :showrails
    assert_response :success
  end

  test "should get g" do
    get :g
    assert_response :success
  end

  test "should get controller" do
    get :controller
    assert_response :success
  end

  test "should get welcome" do
    get :welcome
    assert_response :success
  end

  test "should get show" do
    get :show
    assert_response :success
  end

end
