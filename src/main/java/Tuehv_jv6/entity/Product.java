package Tuehv_jv6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Tuehv_jv6.entity.Category;
import Tuehv_jv6.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @NotNull(message = "Name is not Null")
    @Size(min = 5, message = "Name size too short")
    @Size(max = 50, message = "Name size too long")
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Image", nullable = false, length = 50)
    private String image;

    @NotNull(message = "Price is not Null")
    @Min(value = 0)
    @Column(name = "Price", nullable = false)
    private Integer price;

    @Column(name = "Createdate", nullable = false)
    private LocalDate createDate;

    @Column(name = "Available", nullable = false)
    private Integer available;

    @NotNull(message = "Category is not Null")
    @ManyToOne
    @JoinColumn(name = "Categoryid")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;
}
