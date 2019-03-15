package com.pigyrj.kep.server.auth.jwt;

import io.jsonwebtoken.Header;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author YRJ
 * @date 2019/3/14
 * jwt header info
 */
public class JwtHeader implements Header{

    @Override
    public String getType() {
        return null;
    }

    @Override
    public Header setType(String s) {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public Header setContentType(String s) {
        return null;
    }

    @Override
    public String getCompressionAlgorithm() {
        return null;
    }

    @Override
    public Header setCompressionAlgorithm(String s) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
