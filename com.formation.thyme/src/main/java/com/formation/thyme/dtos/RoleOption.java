package com.formation.thyme.dtos;

import java.util.List;

/**
 * Bean Servant à récuperer les ids de roles choisis par l'utilisateur
 * Lors de la modification ou de la création d'un user et des rôles associés
 */
public class RoleOption {
    private List<String> selected;

    public RoleOption(){}

    public List<String> getSelected() {
        return selected;
    }

    public RoleOption setSelected(List<String> selected) {
        this.selected = selected;
        return this;
    }

    @Override
    public String toString() {
        return "RoleOption{" +
                "selected=" + selected +
                '}';
    }
}
