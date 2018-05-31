
package contracts;

org.springframework.cloud.contract.spec.Contract.make {
	description("""
Bad URL request.

```
given:
	bad url
when:
	calling bad url
then:
	respond with file not found error
```

""")
	request {
		method 'GET'
		url '/some-unknown-url'
	}
	response {
		status 404
	}
}
