package com.demo.controller;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;

	// Post- create User
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	// Put- Update User
	@PutMapping("/{productId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") int userId) {
		UserDto updateUser = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updateUser);
	}
	//Admin
	// Delete User
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{productId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable int userId) {
		this.userService.deleteUser(userId);
		return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}

	// Get User
	@GetMapping("{productId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable int userId) {
		UserDto userById = this.userService.getUserById(userId);
		return ResponseEntity.ok(userById);
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser() {
		List<UserDto> allUser = this.userService.allUser();
		return ResponseEntity.ok(allUser);
	}
}
