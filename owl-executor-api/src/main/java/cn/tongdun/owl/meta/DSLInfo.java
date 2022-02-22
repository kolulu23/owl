package cn.tongdun.owl.meta;

import cn.tongdun.owl.type.OwlType;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liutianlu
 * <br/>Created 2022/2/22 2:06 PM
 */
public class DSLInfo implements Serializable {
    private static final long serialVersionUID = -584561023778969733L;
    /**
     * Name of DSL
     */
    private String name;

    /**
     * Preserved keywords like 'for', 'if', 'return'
     */
    private Set<String> keywords;

    /**
     * Type names allowed to be used like 'int'
     */
    private Set<String> typeNames;

    public DSLInfo() {
        keywords = new HashSet<>();
        typeNames = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    public Set<String> getTypeNames() {
        return typeNames;
    }

    public void setTypeNames(Set<String> typeNames) {
        this.typeNames = typeNames;
    }

    public void addKeyWord(String keyword) {
        this.keywords.add(keyword);
    }

    public void addTypeName(String type){
        this.keywords.add(type);
    }
}
