package com.app.controllers;

import com.app.entites.Address;
import com.app.payloads.AddressDTO;
import com.app.services.AddressService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin")
@SecurityRequirement(name = "E-Commerce Application")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/address")
	public ResponseEntity<AddressDTO> createAddress(@Valid @RequestBody AddressDTO addressDTO) {
		AddressDTO savedAddressDTO = addressService.createAddress(addressDTO);
		
		return new ResponseEntity<AddressDTO>(savedAddressDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("/addresses")
	public ResponseEntity<List<AddressDTO>> getAddresses() {
		List<AddressDTO> addressDTOs = addressService.getAddresses();
		
		return new ResponseEntity<List<AddressDTO>>(addressDTOs, HttpStatus.FOUND);
	}
	
	@GetMapping("/addresses/{addressId}")
	public ResponseEntity<AddressDTO> getAddress(@PathVariable Long addressId) {
		AddressDTO addressDTO = addressService.getAddress(addressId);
		
		return new ResponseEntity<AddressDTO>(addressDTO, HttpStatus.FOUND);
	}
	
	@PutMapping("/addresses/{addressId}")
	public ResponseEntity<AddressDTO> updateAddress(@PathVariable Long addressId, @RequestBody Address address) {
		AddressDTO addressDTO = addressService.updateAddress(addressId, address);
		
		return new ResponseEntity<AddressDTO>(addressDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/addresses/{addressId}")
	public ResponseEntity<String> deleteAddress(@PathVariable Long addressId) {
		String status = addressService.deleteAddress(addressId);
		
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
}
