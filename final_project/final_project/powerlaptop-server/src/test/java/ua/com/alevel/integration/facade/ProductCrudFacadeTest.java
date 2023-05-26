package ua.com.alevel.integration.facade;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.data.datatable.DataTableResponse;
import ua.com.alevel.data.dto.product.ProductDto;
import ua.com.alevel.facade.crud.ProductCrudFacade;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.type.ProductBrandType;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductCrudFacadeTest {

    @Autowired
    private ProductCrudFacade productCrudFacade;

    private static final String PRODUCT_NAME = "TestName";
    private static final String PRODUCT_NAME_UPDATE = "TestNameUpdate";
    private static final Long ID = 1L;
    private static ProductDto productDto = new ProductDto();
    private static DataTableRequest request = new DataTableRequest();

    @BeforeAll
    static void setUp() {
        productDto.setName(PRODUCT_NAME);
        productDto.setProductBrand(ProductBrandType.HP);
        request.setPage(0);
        request.setSize(10);
        request.setSort("desc");
        request.setOrder("id");
    }

    @Test
    @Order(1)
    public void shouldBeCreateProductWhenFieldsIsCorrect() {
        // given
        productCrudFacade.create(productDto);

        // when
        productDto = productCrudFacade.findById(ID);

        // then
        assertThat(productDto.getId()).isEqualTo(ID);
        assertThat(productDto.getName()).isEqualTo(PRODUCT_NAME);
        assertThat(productDto.getProductBrand()).isEqualTo(ProductBrandType.HP);
    }

    @Test
    @Order(2)
    public void shouldBeUpdateProductWhenFieldsIsCorrect() {
        // given
        productDto.setName(PRODUCT_NAME_UPDATE);
        productCrudFacade.update(ID, productDto);

        // when
        productDto = productCrudFacade.findById(ID);

        // then
        assertThat(productDto.getName()).isEqualTo(PRODUCT_NAME_UPDATE);
    }

    @Test
    @Order(3)
    public void shouldBeFindAllProducts() {
        // given
        productCrudFacade.create(productDto);

        // when
        DataTableResponse<ProductDto> response = productCrudFacade.findAll(request);

        // then
        assertThat(response.getTotalElements()).isEqualTo(2L);
        assertThat(response.getTotalPages()).isEqualTo(1);
    }
}
