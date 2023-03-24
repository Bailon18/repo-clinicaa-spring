package idat.edu.pe.demo.models.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import idat.edu.pe.demo.models.entity.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {


        // Bloquear un usuario atravez del estado y id
        @Transactional
        @Modifying
        @Query("update Usuario u set u.estado = 'Inactivo' where u.id = ?1")
        void bloquearUsuario(Long id);

        @Query("select u FROM Usuario u WHERE u.correo = ?1 and u.contrasena = ?2")
        Usuario validarIngreso(String usuario, String contrasena);

        @Query("select u FROM Usuario u WHERE u.correo = ?1")
        Usuario validarCorreo(String correo);

        @Query("select u FROM Usuario u WHERE u.dni = ?1")
        Usuario validarDni(String dni);
}
