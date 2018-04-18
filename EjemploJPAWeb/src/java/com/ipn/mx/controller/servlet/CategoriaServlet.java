/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controller.servlet;

import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.entidades.Categoria;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asuncionez
 */
@WebServlet(name = "CategoriaServlet", urlPatterns = {"/CategoriaServlet"})
public class CategoriaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "listado":
                listado(request, response);
                break;
            case "nuevo":
                agregarCategoria(request, response);
                break;
            case "eliminar":
                eliminarCategoria(request, response);
                break;
            case "actualizar":
                actualizarCategoria(request, response);
                break;
            case "guardar":
                almacenarCategoria(request, response);
                break;
            default:
                break;
        }
    }

    private void listado(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CategoriaDAO dao = new CategoriaDAO();
        request.setAttribute("listaDeCategorias", dao.readAll());
        RequestDispatcher rd = request.getRequestDispatcher("listado.jsp");
        rd.forward(request, response);
    }

    private void agregarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("categoriaForm.jsp");
        rd.forward(request, response);
    }

    private void eliminarCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CategoriaDAO dao = new CategoriaDAO();
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(Integer.parseInt(request.getParameter("id")));
        dao.delete(categoria);
        listado(request, response);
    }

    private void actualizarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(Integer.parseInt(request.getParameter("id")));
        CategoriaDAO dao = new CategoriaDAO();
        categoria = dao.read(categoria);
        request.setAttribute("categoria", categoria);
        RequestDispatcher rd = request.getRequestDispatcher("categoriaForm.jsp");
        rd.forward(request, response);
    }

    private void almacenarCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Categoria categoria = new Categoria();
        CategoriaDAO dao = new CategoriaDAO();
        if (request.getParameter("txtIdCategoria") == null || request.getParameter("txtIdCategoria").isEmpty()) {
            categoria.setNombreCategoria(request.getParameter("txtNombre"));
            categoria.setDescripcionCategoria(request.getParameter("txtDescripcion"));
            dao.create(categoria);
            listado(request, response);
        } else {
            categoria.setIdCategoria(Integer.parseInt(request.getParameter("txtIdCategoria")));
            categoria.setNombreCategoria(request.getParameter("txtNombre"));
            categoria.setDescripcionCategoria(request.getParameter("txtDescripcion"));
            dao.update(categoria);
            listado(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
