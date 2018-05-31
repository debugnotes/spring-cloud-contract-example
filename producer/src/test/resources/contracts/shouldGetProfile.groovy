
org.springframework.cloud.contract.spec.Contract.make {
	description("""
Represents a successful scenario of getting a contract

```
given:
	testing a contract
when:
	calling a service
then:
	respond with a json object
```

""")
	request {
		method 'GET'
		url '/profile'
	}
	response {
		status 200
		body("""
			{"cards":[],"id":101}
		""")
		headers {
			contentType(applicationJson())
		}
	}
}
