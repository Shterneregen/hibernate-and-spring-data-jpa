### JPA Inheritance Strategies  
- **MappedSuperclass** - Abstract parent class, parent is not in the database
- **Table per Class** - Similar to MappedSuperClass, but each type is assigned a database table
- **Single Table** - Single table is used, has properties for all types, uses discriminator value to determine the type database row is mapped to
- **Joined Table** - Each type has a table, sub-types are joined

---
Original: [Spring Data JPA Inheritance](https://github.com/springframeworkguru/sdjpa-inheritance)