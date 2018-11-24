def multiply(num1, num2)
  num1.to_f * num2.to_f
end

puts "give numbers"
num1 = gets.chomp
num2 = gets.chomp

puts "mult of the 2 nums is: #{multiply(num1, num2)}"
