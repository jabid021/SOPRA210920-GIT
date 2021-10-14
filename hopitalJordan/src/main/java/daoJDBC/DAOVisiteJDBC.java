package daoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOVisite;
import model.Medecin;
import model.Patient;
import model.Visite;
import util.Context;

public class DAOVisiteJDBC implements IDAOVisite {

	@Override
	public Visite findById(Integer id) {
		return null;
	}

	@Override
	public List<Visite> findAll() {
		return null;
	}

	@Override
	public Visite save(Visite v) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital","root","");

			PreparedStatement ps = connect.prepareStatement("INSERT INTO visite (prix,date_visite,salle,id_patient,id_medecin) VALUES(?,?,?,?,?)");
			ps.setDouble(1, v.getPrix());
			ps.setString(2, v.getDateVisite().toString());
			ps.setInt(3, v.getSalle());
			ps.setInt(4, v.getPatient().getId());
			ps.setInt(5, v.getMedecin().getId());


			ps.executeUpdate();


			ps.close();
			connect.close();

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void delete(Visite o) {
	}

	public List<Visite> findAllByIdPatient(int idPatient)
	{
		List<Visite> visites = new ArrayList();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital","root","");

			PreparedStatement ps = connect.prepareStatement("SELECT * from visite join compte on visite.id_medecin=compte.id join patient on visite.id_patient=patient.id where id_patient=?");
			
			ps.setInt(1, idPatient);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				//Patient p = Context.getInstance().getDaoP().findById(idPatient);		
				Patient p = new Patient(idPatient, rs.getString("nom"), rs.getString("prenom"));
				Medecin m = new Medecin(rs.getString("login"));
				Visite v = new Visite(rs.getInt("visite.numero"),m,p,rs.getString("date_visite"),rs.getDouble("prix"),rs.getInt("salle"));
				visites.add(v);
			}
			rs.close();
			ps.close();
			connect.close();

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return visites;
	}

}
