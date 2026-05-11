package com.aula.classproblem.user.service;

import java.util.List;
import java.util.stream.Collectors;

import com.aula.classproblem.user.dto.AppUserInput;
import com.aula.classproblem.user.dto.AppUserOutput;
import com.aula.classproblem.user.entity.AppUser;
import com.aula.classproblem.user.mapper.AppUserMapper;
import com.aula.classproblem.user.repository.AppUserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository repository;

    public AppUserServiceImpl(AppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AppUserOutput> findAll() {
        return repository.findAll().stream()
                .map(AppUserMapper::toOutput)
                .collect(Collectors.toList());
    }

    @Override
    public AppUserOutput findById(Long id) {
        return repository.findById(id)
                .map(AppUserMapper::toOutput)
                .orElse(null);
    }

    @Override
    public AppUserOutput create(AppUserInput input) {
        AppUser entity = AppUserMapper.toEntity(input);
        AppUser saved = repository.save(entity);
        return AppUserMapper.toOutput(saved);
    }

    @Override
    public AppUserOutput update(Long id, AppUserInput input) {
        return repository.findById(id).map(existing -> {
            existing.setUsername(input.getUsername());
            existing.setFullName(input.getFullName());
            existing.setEmail(input.getEmail());
            existing.setRoles(input.getRoles());
            AppUser saved = repository.save(existing);
            return AppUserMapper.toOutput(saved);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
