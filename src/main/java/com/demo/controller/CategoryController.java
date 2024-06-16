package com.demo.controller;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	// create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCatogory(@Valid @RequestBody CategoryDto categoryDto) {
		System.out.println(categoryDto);
		CategoryDto category = this.categoryServiceImpl.createCategory(categoryDto);
		System.out.println("controller after");
		return new ResponseEntity<>(category, HttpStatus.CREATED);
	}

	// update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable("categoryId") int categoryId) {
		CategoryDto updateCategory = this.categoryServiceImpl.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<>(updateCategory, HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable int categoryId) {
		this.categoryServiceImpl.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("catogory is deleted successfully !!", true),
				HttpStatus.OK);
	}

	// get
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable int categoryId) {
		CategoryDto category = this.categoryServiceImpl.getCategory(categoryId);
		return new ResponseEntity<CategoryDto>(category, HttpStatus.OK);
	}

	// get All
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory() {
		List<CategoryDto> categories = this.categoryServiceImpl.getCategories();
		return ResponseEntity.ok(categories);
	}

}
