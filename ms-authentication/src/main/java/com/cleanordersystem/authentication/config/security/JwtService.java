package com.cleanordersystem.authentication.config.security;

import com.cleanordersystem.authentication.core.domain.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import static com.cleanordersystem.authentication.core.constants.TokenConstants.ACCESS_TOKEN_EXPIRATION;
import static com.cleanordersystem.authentication.core.constants.TokenConstants.REFRESH_TOKEN_EXPIRATION;

@Service
public class JwtService {

    private final Key key;

    public JwtService() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    /**
     * Gera um token JWT para o usuário fornecido.
     * @param user O usuário para o qual o token será gerado.
     * @return O token JWT gerado.
     */
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Gera um token de atualização (refresh token) para o email fornecido.
     * @param email O email para o qual o token de atualização será gerado.
     * @return O token de atualização gerado.
     */
    public String generateRefreshToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Verifica se o token JWT é válido para o email fornecido.
     * @param token O token JWT a ser validado.
     * @param email O email associado ao token.
     * @return true se o token for válido, false caso contrário.
     */
    public boolean isTokenValid(String token, String email) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            // Log token expirado
            return false;
        } catch (UnsupportedJwtException e) {
            // Log token não suportado
            return false;
        } catch (MalformedJwtException e) {
            // Log token malformado
            return false;
        } catch (SignatureException e) {
            // Log assinatura inválida
            return false;
        } catch (IllegalArgumentException e) {
            // Log argumento ilegal
            return false;
        }
    }

    /**
     * Extrai o nome de usuário (email) do token JWT.
     * @param token O token JWT do qual o nome de usuário será extraído.
     * @return O nome de usuário extraído do token.
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extrai uma reivindicação específica do token JWT.
     * @param token O token JWT do qual a reivindicação será extraída.
     * @param claimsResolver A função para resolver a reivindicação.
     * @param <T> O tipo da reivindicação.
     * @return A reivindicação extraída do token.
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Extrai todas as reivindicações do token JWT.
     * @param token O token JWT do qual as reivindicações serão extraídas.
     * @return As reivindicações extraídas do token.
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody();
    }
}