
package contracts;

org.springframework.cloud.contract.spec.Contract.make {
	description("""
Service online check.
```
given:
	a motive to test the service
when:
	calling the service
then:
	respond with an ok message
```

""")
	request {
		method 'GET'
		url '/'
	}
	response {
		status 200
	}
}
