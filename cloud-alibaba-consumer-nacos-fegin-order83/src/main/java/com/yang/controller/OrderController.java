package com.yang.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yang.api.PaymentApi;

@RestController
public class OrderController {
	@Autowired
	private PaymentApi paymentApi;

	@GetMapping("/consumer/find/{id}")
	public String find(@PathVariable("id") int id) {
		return paymentApi.find(id);
	}

	public static void main(String[] args) {
		int[] arr= {2,1,9,5,4,6,5,1,2,8,13,9};
		for(int i=0;i<arr.length-1;i++){
		  for(int j=0;j<arr.length-1-i;j++){
		   if(arr[j]>arr[j+1]){
		int temp = arr[j];
		arr[j] = arr[j+1];
		arr[j+1] = temp;
		}
		}
		}
		Set<Integer> data = new HashSet<>();
		for(int i:arr){
		data.add(i);
		}
		System.out.print(data);
	}
}
