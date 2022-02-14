package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {
    @Test
    public void whenAddAndFindThenUserRoleIsAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        Role result = store.findById("1");
        assertThat(result.getUsername(), is("Admin"));
    }

    @Test
    public void whenAddAndFindThenUserRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        Role result = store.findById("10");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindUserRoleIsAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.add(new Role("1", "Operator"));
        Role result = store.findById("1");
        assertThat(result.getUsername(), is("Admin"));
    }

    @Test
    public void whenReplaceThenUserRoleIsOperator() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.replace("1", new Role("1", "Operator"));
        Role result = store.findById("1");
        assertThat(result.getUsername(), is("Operator"));
    }

    @Test
    public void whenNoReplaceRoleThenNoChangeUserRole() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.replace("10", new Role("10", "Operator"));
        Role result = store.findById("1");
        assertThat(result.getUsername(), is("Admin"));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteRoleThenUserRoleIsAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getUsername(), is("Admin"));
    }
}