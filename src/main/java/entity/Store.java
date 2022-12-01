package entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Store {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(min = 5, max = 100)
    @NotBlank
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Size(min = 5, max = 100)
    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @OneToMany(mappedBy = "store", orphanRemoval = true)
    private Set<StoreAccount> storeAccounts = new LinkedHashSet<>();

}
