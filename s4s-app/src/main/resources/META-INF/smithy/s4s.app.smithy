$version: "2"

namespace s4s.app

use alloy#simpleRestJson
use alloy#UUID
use s4s.smithy#Fraction

@simpleRestJson
service Fractions {
  version: "1.0.0",
  operations: [Set]
}

@http(method: "POST", uri: "/fractions/{name}/{fraction}", code: 200)
operation Set {

  input := {

    @httpLabel
    @required
    name: String
    
    @httpLabel
    @required
    fraction: Fraction

  }

  output := {

    @required
    message: String
    
  }

}