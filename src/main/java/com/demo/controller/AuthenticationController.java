package com.demo.controller;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	@Autowired
	private final AuthenticationService service;
	@Autowired
	private UserService userService ;

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {

		return ResponseEntity.status(HttpStatus.OK).body(service.authenticate(request));

	}
	// register new user
	
		@PostMapping("/register")
		public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
			UserDto registerUser = this.userService.registerNewUser(userDto);
			return new ResponseEntity<UserDto>(registerUser,HttpStatus.CREATED);
		}

}