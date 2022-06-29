package br.com.vnrg.sagaorderservice.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Order
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-06-28T23:00:05.420767756-03:00[America/Sao_Paulo]")
public class Order implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("orderType")
  private UUID orderType;

  @JsonProperty("orderDescription")
  private String orderDescription;

  @JsonProperty("orderValue")
  private BigDecimal orderValue;

  @JsonProperty("productId")
  private UUID productId;

  @JsonProperty("productItems")
  private Integer productItems;

  @JsonProperty("productDescription")
  private String productDescription;

  @JsonProperty("customerId")
  private UUID customerId;

  public Order orderType(UUID orderType) {
    this.orderType = orderType;
    return this;
  }

  /**
   * Get orderType
   * @return orderType
  */
  @Valid 
  @Schema(name = "orderType", required = false)
  public UUID getOrderType() {
    return orderType;
  }

  public void setOrderType(UUID orderType) {
    this.orderType = orderType;
  }

  public Order orderDescription(String orderDescription) {
    this.orderDescription = orderDescription;
    return this;
  }

  /**
   * Get orderDescription
   * @return orderDescription
  */
  
  @Schema(name = "orderDescription", required = false)
  public String getOrderDescription() {
    return orderDescription;
  }

  public void setOrderDescription(String orderDescription) {
    this.orderDescription = orderDescription;
  }

  public Order orderValue(BigDecimal orderValue) {
    this.orderValue = orderValue;
    return this;
  }

  /**
   * Get orderValue
   * @return orderValue
  */
  @Valid 
  @Schema(name = "orderValue", required = false)
  public BigDecimal getOrderValue() {
    return orderValue;
  }

  public void setOrderValue(BigDecimal orderValue) {
    this.orderValue = orderValue;
  }

  public Order productId(UUID productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  */
  @Valid 
  @Schema(name = "productId", required = false)
  public UUID getProductId() {
    return productId;
  }

  public void setProductId(UUID productId) {
    this.productId = productId;
  }

  public Order productItems(Integer productItems) {
    this.productItems = productItems;
    return this;
  }

  /**
   * Get productItems
   * minimum: 1
   * @return productItems
  */
  @Min(1) 
  @Schema(name = "productItems", required = false)
  public Integer getProductItems() {
    return productItems;
  }

  public void setProductItems(Integer productItems) {
    this.productItems = productItems;
  }

  public Order productDescription(String productDescription) {
    this.productDescription = productDescription;
    return this;
  }

  /**
   * Get productDescription
   * @return productDescription
  */
  
  @Schema(name = "productDescription", required = false)
  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public Order customerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  */
  @Valid 
  @Schema(name = "customerId", required = false)
  public UUID getCustomerId() {
    return customerId;
  }

  public void setCustomerId(UUID customerId) {
    this.customerId = customerId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.orderType, order.orderType) &&
        Objects.equals(this.orderDescription, order.orderDescription) &&
        Objects.equals(this.orderValue, order.orderValue) &&
        Objects.equals(this.productId, order.productId) &&
        Objects.equals(this.productItems, order.productItems) &&
        Objects.equals(this.productDescription, order.productDescription) &&
        Objects.equals(this.customerId, order.customerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderType, orderDescription, orderValue, productId, productItems, productDescription, customerId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    sb.append("    orderType: ").append(toIndentedString(orderType)).append("\n");
    sb.append("    orderDescription: ").append(toIndentedString(orderDescription)).append("\n");
    sb.append("    orderValue: ").append(toIndentedString(orderValue)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    productItems: ").append(toIndentedString(productItems)).append("\n");
    sb.append("    productDescription: ").append(toIndentedString(productDescription)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

