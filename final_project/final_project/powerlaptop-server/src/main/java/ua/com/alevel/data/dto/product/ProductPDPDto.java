package ua.com.alevel.data.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.entity.product.ProductImage;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.type.DisplayType;
import ua.com.alevel.persistence.sql.type.OsType;
import ua.com.alevel.persistence.sql.type.ProductBrandType;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ProductPDPDto {

    private Long id;
    private ProductBrandType productBrand;
    private String name;
    private String description;
    private Set<String> images;
    private String price = "100.00";
    private OsType os;
    private String cpu;
    private Integer ram;
    private Integer ssd;
    private String color;
    private String displayResolution;
    private DisplayType displayType;
    private String displaySize;

    public ProductPDPDto(Product product, ProductVariant productVariant) {
        this.id = product.getId();
        this.productBrand = product.getProductBrand();
        this.name = product.getName();
        this.description = product.getDescription();
        Set<ProductImage> productImages = product.getProductImages();
        if (CollectionUtils.isNotEmpty(productImages)) {
            this.images = productImages.stream().map(ProductImage::getImageUrl).collect(Collectors.toSet());
        }
        this.os = productVariant.getOs();
        this.cpu = productVariant.getCpu();
        this.ram = productVariant.getRam();
        this.ssd = productVariant.getSsd();
        this.color = productVariant.getColor();
        this.displayResolution = productVariant.getDisplayResolution();
        this.displayType = productVariant.getDisplayType();
        this.displaySize = productVariant.getDisplaySize();
    }
}