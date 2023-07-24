package com.yjy.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;

@Slf4j
public class JwtUtils {

    public static String signKey = "ityangjy";
    public static Long expire = 43200000L;

    /**
     * 生成jwt令牌
     * @param claims
     * @return
     */
//    map代表json格式
//    - 公开的非静态成员属于类的实例,需要通过对象访问。
//            - 公开的静态成员属于类本身,可以通过类名直接访问。
    public static String generateJwt(Map<String,Object> claims){
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,signKey)
                .setExpiration(new Date(System.currentTimeMillis()+expire))
                .compact();

        return jwt;
    }

    /**
     * 解析jwt令牌
     * @param jwt
     * @return
     */
    public static Claims parseJwt(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
