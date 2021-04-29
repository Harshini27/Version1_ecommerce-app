package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.ProductCategoryRepository;
import com.ecommerce.dao.ProductRepository;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductCategory;
import com.ecommerce.entity.ProductRequest;
import com.ecommerce.entity.User;

@Service
public class ProductService {
	
	ProductCategoryRepository productCategoryRepository;
	ProductRepository productRepository;
	@Autowired
	public ProductService(ProductCategoryRepository productCategoryRepository,ProductRepository productRepository)
	{
		this.productCategoryRepository=productCategoryRepository;
		this.productRepository=productRepository;
	}
	
	public ProductCategory findById(Long id) {
		Optional<ProductCategory> optional = productCategoryRepository.findById(id);
		return optional.orElse(null);
	}
    
	
	    public Product createProduct(Product product)  {
		Product products = productRepository.findBySku(product.getSku());
        System.out.println();
        if(products==null)
        {
        	return productRepository.save(product);
        }
        else
        {
        	return null;
        }
	  }

	   public ProductCategory createProductCategory(ProductCategory productCategory) {
		Optional<ProductCategory> productCategory1 = productCategoryRepository.findByCategoryName(productCategory.getCategoryName());
        System.out.println();
        if(!productCategory1.isPresent())
        {
        	return productCategoryRepository.save(productCategory);
        }
        else
        {
        	return null;
        }
	}

	public ProductRequest createProductWithCategory(ProductRequest productRequest) {
		Optional<ProductCategory> productCategoryOpt = productCategoryRepository.findByCategoryName(productRequest.getCategoryName());
		Product product=null ;
		if(productCategoryOpt.isPresent()) {
			product = mapToProduct(productRequest, productCategoryOpt.get());
		}
		else
		{
			ProductCategory productCategory = new ProductCategory();
			productCategory.setCategoryName(productRequest.getCategoryName());
			productCategory=productCategoryRepository.save(productCategory);
			product = mapToProduct(productRequest, productCategory);
		}
		
		Product products = productRepository.findBySku(product.getSku());
        System.out.println();
        if(products==null)
        {
        	 productRepository.save(product);
        	 return productRequest;
        }
        else
        {
        	return null;
        }
		
	}

	private Product mapToProduct(ProductRequest productRequest, ProductCategory productCategory) {
		
		return Product.builder()
				.sku(productRequest.getSku())
				.imageUrl(productRequest.getImageUrl())
				.description(productRequest.getDescription())
				.name(productRequest.getName())
				.unitPrice(productRequest.getUnitPrice())
				.unitsInStock(productRequest.getUnitsInStock())
				.categoryId(productCategory.getId())
				.build();
	}
}
