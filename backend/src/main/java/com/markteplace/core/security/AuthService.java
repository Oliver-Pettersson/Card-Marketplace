package com.markteplace.core.security;

import com.markteplace.core.error.UsernameAlreadyExistsException;
import com.markteplace.domain.user.User;
import com.markteplace.domain.user.UserService;
import com.markteplace.domain.user.dto.UserMapper;
import com.markteplace.domain.user.dto.UserSignUpDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {
    private final JWTManager jwtManager;
    private final UserService userService;
    private final UserMapper userMapper;

    public AuthService(JWTManager jwtManager, UserService userService, UserMapper userMapper) {
        this.jwtManager = jwtManager;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public Map<String, String> refreshToken(String authHeader) {
        String refreshToken = authHeader.substring("Bearer ".length());
        String username = jwtManager.verifyToken(refreshToken).getSubject();
        String accessToken = jwtManager.createAccessToken(username);
        refreshToken = jwtManager.createRefreshToken(username);
        return Map.of("access_token", accessToken, "refresh_token", refreshToken);
    }

    public User signUp(UserSignUpDTO userSignUpDTO) throws UsernameAlreadyExistsException {
        if (userService.findByUsername(userSignUpDTO.getUsername()) != null)
            throw new UsernameAlreadyExistsException();
        return userService.create(userService.preSave(userMapper.fromSignUpDTO(userSignUpDTO)));
    }
}
