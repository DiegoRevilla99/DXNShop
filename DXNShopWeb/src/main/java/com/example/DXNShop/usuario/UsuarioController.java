/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.usuario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author aleja
 */
@Controller
@RequestMapping(path="/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /*
    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }*/
    @GetMapping("/perfil")
    public String inicio() {
        return "DXN-Shop-main/perfil/perfil_usuario";
    }
    
    @GetMapping("/index")
    public String inicioUsuario() {
        return "DXN-Shop-main/index";
    }
    
    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("usuarioList", usuarioService.getUsuarios());
        return "DXN-Shop-main/login";
    }

     //Modificamos getClientes
    @GetMapping("/mostrar")
    public String getUsuarios(Model model) {
        model.addAttribute("usuarioList", usuarioService.getUsuarios());
        return "DXN-Shop-main/perfil/usuario-list";
    }
   @GetMapping("/registro")
    public String agregarCliente(Model model){
        model.addAttribute("usuario",new Usuario());
        return "DXN-Shop-main/registro";
    }
    @PostMapping("/agregar")
    public String registerNewCliente(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttrs){
        usuarioService.addNewUsuario(usuario);
        redirectAttrs
                .addFlashAttribute("mensaje","Agregado correctamente")
                .addFlashAttribute("clase","success");
        return "redirect:/usuario/login";
    }
 
    
    
    @PostMapping
    public void registerNewUsuario(@RequestBody Usuario usuario) {
        usuarioService.addNewUsuario(usuario);
    }

    @DeleteMapping(path = "{email}")
    public void deleteUsuario(@PathVariable("email") String email) {
        usuarioService.deleteUsuario(email);
    }

    //Método para desplegar formularion de edición
    @GetMapping(path = "/editarusuario/{email}")
    public String editarUsuario(@PathVariable("email")String email, Model model){
        model.addAttribute("usuario", usuarioService.getUsuario(email));
        return "DXN-Shop-main/perfil/editar-usuario";
    }

    //Actualizar un cliente
    @PostMapping(path= "/editarusuario")
    public String updateUsuario(@ModelAttribute Usuario usuario){
        usuarioService.updateUsuario(usuario.getEmail(), usuario.getPass(),
                usuario.getNombre(), usuario.getApellidos(), usuario.getTelefono(),usuario.getRol_id());
        return "redirect:/usuario/mostrar";
    }
    
    
    
    
    
    
    
    
    
     //Eliminar un cliente
    @GetMapping(path = "/eliminar/{email}")
    public String deleteCliente(@PathVariable("email")String email){
        usuarioService.deleteUsuario(email);
        return "redirect:/usuario/mostrar";
    }

}
