class Student
  attr_accessor :firstName, :lastName, :email, :username, :password

  def initialize(firstName, lastName, username, email, password)
    @firstName = firstName
    @lastName = lastName
    @username = username
    @email = email
    @password = password
  end

  def to_s
    "First name #{@firstName}, Last name: #{@lastName}, Username: #{@username}, email: #{@email}"
  end


end


jon = Student.new("jon", "ann", "ja", "jann@gmail.com", "1234")
puts jon.to_s
