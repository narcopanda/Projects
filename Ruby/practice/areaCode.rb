phoneBook = {
  "ny" => "212",
  "newBrun" => "732",
  "sanfran" => "301",
  "miami" => "305",
  "pal" => "650",
  "seattle" => "111",
  "xyz" => "123"
  
}

def getCityName(hash)
  hash.each{ |key, value| puts key }
end

def getAreaCode(hash, key)
  hash.each { |newkey, value|
    if key == newkey
      puts value
    end
  }
end

puts "enter city name"
aws = gets.chomp.downcase
getAreaCode(phoneBook, aws)




