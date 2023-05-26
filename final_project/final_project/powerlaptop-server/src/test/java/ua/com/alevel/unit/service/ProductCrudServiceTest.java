package ua.com.alevel.unit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import ua.com.alevel.exception.FieldEmptyException;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.repository.product.ProductRepository;
import ua.com.alevel.persistence.sql.type.ProductBrandType;
import ua.com.alevel.service.crud.CrudHelperService;
import ua.com.alevel.service.crud.product.impl.ProductCrudServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static ua.com.alevel.util.ExceptionUtil.*;

@SpringBootTest
public class ProductCrudServiceTest {

    @InjectMocks
    private ProductCrudServiceImpl service;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CrudHelperService<Product, ProductRepository> crudHelperService;

    private Product product = new Product();

    private static final String PRODUCT_NAME = "TestName";

    @Test
    public void shouldBeCreateProductWhenCrudHelperServiceWasCalled() {
        // given
        product.setName(PRODUCT_NAME);
        product.setProductBrand(ProductBrandType.HP);

        // when
        service.create(product);

        // then
        verify(crudHelperService, times(1)).create(product, productRepository);
    }

    @Test
    public void shouldBeCreateProductWhenProductBrandIsNull() {
        // given
        product.setProductBrand(null);
        product.setName(PRODUCT_NAME);

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.create(product));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(PRODUCT_BRAND_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeCreateProductWhenNameIsNull() {
        // given
        product.setName(null);
        product.setProductBrand(ProductBrandType.HP);

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.create(product));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(PRODUCT_NAME_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeUpdateProductWhenCrudHelperServiceWasCalled() {
        // given
        product.setId(1L);
        product.setName(PRODUCT_NAME);
        product.setProductBrand(ProductBrandType.HP);

        // when
        service.update(product);

        // then
        verify(crudHelperService, times(1)).update(product, productRepository);
    }

    @Test
    public void shouldBeUpdateProductWhenProductIdIsNull() {
        // given
        product.setId(null);
        product.setName(PRODUCT_NAME);
        product.setProductBrand(ProductBrandType.HP);

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.update(product));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(ENTITY_ID_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeUpdateProductWhenProductIdIsLessZero() {
        // given
        product.setId(0L);
        product.setName(PRODUCT_NAME);
        product.setProductBrand(ProductBrandType.HP);

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.update(product));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(ENTITY_ID_IS_INCORRECT);
    }

    @Test
    public void shouldBeUpdateProductWhenProductBrandIsNull() {
        // given
        product.setProductBrand(null);
        product.setName(PRODUCT_NAME);

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.update(product));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(PRODUCT_BRAND_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeUpdateProductWhenNameIsNull() {
        // given
        product.setName(null);
        product.setProductBrand(ProductBrandType.HP);

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.update(product));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(PRODUCT_NAME_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeFindByIdProductWhenIdIsCorrect() {
        // given
        final Long id = 1L;
        product.setId(id);
        when(crudHelperService.findById(id, productRepository)).thenReturn(product);

        // when
        product = service.findById(id);

        // then
        assertEquals(product.getId(), id);
    }

    @Test
    public void shouldBeFindByIdProductWhenIdIsNull() {
        // given
        final Long id = null;

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.findById(id));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(ENTITY_ID_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeFindByIdProductWhenIdIsZero() {
        // given
        final Long id = 0L;

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.findById(id));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(ENTITY_ID_IS_INCORRECT);
    }
}
