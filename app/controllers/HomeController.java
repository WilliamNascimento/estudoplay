package controllers;
import play.mvc.*;
import views.html.*;
import javax.inject.Inject;
import play.data.*;
import models.*;
import java.util.List;



public class HomeController extends Controller {
    
    @Inject
    FormFactory formFactory;
    @Inject
    Profissional profissional;


    public Result index() {
        return ok(index.render("alô mundo...."));
    }

    public Result cadastroDeProfissional(){
        Form<Profissional> formularioDeProfissional = formFactory
        .form(Profissional.class);
        return ok(cadastroDeProfissional.render("Cadatro",formularioDeProfissional));
    }

    public Result cadastroDeNovoProfissional(){
        //pega as informações que vem do formulário
        Form<Profissional> formProfissional = formFactory.form(Profissional.class).bindFromRequest();

        //valida se tem aglum erro
        if(formProfissional.hasErrors()){
            flash("danger", "Tem erros no formulario");
            return badRequest(cadastroDeProfissional.render("Cadastro", formProfissional));
        }

        //atribui os dados ao objeto produto
        profissional = formProfissional.get() ;
        //salva o produto
        if(profissional.id != null)
            profissional.update();
        else
            profissional.save();
        //notifica o usuário que o produto foi salvo
        flash("success", "Novo produto adicionado: "+profissional.nome);

        //redireciona para a tela de cadastro novamente
        return redirect(routes.HomeController.listaTudo());
    }

    public Result editarProfissional(Long id){
        Profissional p = profissional.find.byId(id);
        Form<Profissional> formProfissional = 
        formFactory.form(Profissional.class).fill(p);
        
        return ok(cadastroDeProfissional
        .render("Editar",formProfissional));

    }

    public Result listaTudo(){
        List<Profissional> list = profissional.find.all();
        return ok(listProfissional.render(list));
    }

      public Result deletar(Long id){
        Profissional profissional = Profissional.find.byId(id);
        
        if(profissional == null){
            return notFound("Profissional não encontrado!");
        }
        Profissional p = profissional.find.byId(id);
        p.delete();                
        

        return redirect(routes.HomeController.listaTudo());
    }

     public Result buscarProfissional(Long id) {
        return ok(encontrarProfissional.render("alô mundo...."));
    }

}
