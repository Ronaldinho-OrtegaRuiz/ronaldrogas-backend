package com.ronaldrogas.backend.users.application.services;

import com.ronaldrogas.backend.users.domain.exceptions.UserException;
import com.ronaldrogas.backend.users.domain.models.Address;
import com.ronaldrogas.backend.users.domain.models.Phone;
import com.ronaldrogas.backend.users.domain.models.User;
import com.ronaldrogas.backend.users.domain.ports.input.UserUseCase;
import com.ronaldrogas.backend.users.domain.ports.output.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserException("Usuario no encontrado"));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email)
                .orElseThrow(() -> new UserException("Usuario no encontrado"));
    }

    public User createUser(User user) {
        List<String> errors = new ArrayList<>();

        if (userRepository.existsByEmail(user.getEmail())) {
            errors.add("El correo ya está registrado");
        }
        if (user.getName() == null || user.getName().trim().length() < 3) {
            errors.add("El nombre debe tener al menos 3 caracteres");
        }
        if (user.getPhones() == null || user.getPhones().isEmpty()) {
            errors.add("El usuario debe tener al menos un teléfono");
        } else if (user.getPhones().stream().anyMatch(phone -> phone.getNumber().length() != 10)) {
            errors.add("Cada teléfono debe tener exactamente 10 caracteres");
        }
        if (user.getAddresses() == null || user.getAddresses().isEmpty()) {
            errors.add("El usuario debe tener al menos una dirección");
        }

        if (!errors.isEmpty()) {
            throw new UserException(String.join("; ", errors));
        }

        // Asignar el usuario a cada dirección y establecer siempre "Colombia" como país
        user.getAddresses().forEach(address -> {
            address.setUser(user);  // 🔹 Asignar usuario a la dirección
            if (address.getCountry() == null || address.getCountry().trim().isEmpty()) {
                address.setCountry("Colombia");
            }
        });

        user.getPhones().forEach(phone -> phone.setUser(user));  // 🔹 Asignar usuario al teléfono

        System.out.println("Direcciones antes de guardar: " + user.getAddresses());
        System.out.println("Teléfonos antes de guardar: " + user.getPhones());

        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserException("Usuario no encontrado"));

        List<String> errors = new ArrayList<>();

        // Validación del email solo si es diferente
        if (!existingUser.getEmail().equals(user.getEmail()) && userRepository.existsByEmail(user.getEmail())) {
            errors.add("El correo ya está registrado por otro usuario");
        }
        if (user.getName() == null || user.getName().trim().length() < 3) {
            errors.add("El nombre debe tener al menos 3 caracteres");
        }
        if (user.getPhones() == null || user.getPhones().isEmpty()) {
            errors.add("El usuario debe tener al menos un teléfono");
        } else if (user.getPhones().stream().anyMatch(phone -> phone.getNumber().length() != 10)) {
            errors.add("Cada teléfono debe tener exactamente 10 caracteres");
        }
        if (user.getAddresses() == null || user.getAddresses().isEmpty()) {
            errors.add("El usuario debe tener al menos una dirección");
        }

        if (!errors.isEmpty()) {
            throw new UserException(String.join("; ", errors));
        }

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        Map<Long, Address> existingAddressesMap = existingUser.getAddresses().stream()
                .collect(Collectors.toMap(Address::getId, a -> a));

        List<Address> updatedAddresses = new ArrayList<>();
        for (Address newAddress : user.getAddresses()) {
            Address addressToUpdate = existingAddressesMap.getOrDefault(newAddress.getId(), newAddress);
            addressToUpdate.setStreet(newAddress.getStreet());
            addressToUpdate.setCity(newAddress.getCity());
            addressToUpdate.setDepartment(newAddress.getDepartment());
            addressToUpdate.setReference(newAddress.getReference());
            addressToUpdate.setCountry(newAddress.getCountry() == null ? "Colombia" : newAddress.getCountry());
            addressToUpdate.setUser(existingUser);
            updatedAddresses.add(addressToUpdate);
        }
        existingUser.setAddresses(updatedAddresses);

        Map<Long, Phone> existingPhonesMap = existingUser.getPhones().stream()
                .collect(Collectors.toMap(Phone::getId, p -> p));

        List<Phone> updatedPhones = new ArrayList<>();
        for (Phone newPhone : user.getPhones()) {
            Phone phoneToUpdate = existingPhonesMap.getOrDefault(newPhone.getId(), newPhone);
            phoneToUpdate.setNumber(newPhone.getNumber());
            phoneToUpdate.setUser(existingUser);
            updatedPhones.add(phoneToUpdate);
        }
        existingUser.setPhones(updatedPhones);

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
