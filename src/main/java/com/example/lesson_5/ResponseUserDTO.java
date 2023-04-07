package com.example.lesson_5;

import java.util.Objects;
import java.util.UUID;

public class ResponseUserDTO extends CreateUserDTO{
    private UUID id;

    public ResponseUserDTO(CreateUserDTO data, UUID id) {
        super(data.getName(), data.getAge(), data.getGender(), data.getCompany(), data.getEmail(), data.getPhone());
        this.id = id;
    }

    public ResponseUserDTO() {
        super();;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ResponseUserDTO that = (ResponseUserDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "PublicUserDTO{" +
                "id=" + id +
                '}';
    }
}