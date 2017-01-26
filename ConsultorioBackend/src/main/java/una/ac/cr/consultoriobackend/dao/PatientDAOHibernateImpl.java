/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.consultoriobackend.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import una.ac.cr.consultoriobackend.model.Patient;
import una.ac.cr.consultoriobackend.model.PatientAppointment;

/**
 *
 * @author cristian
 */
public class PatientDAOHibernateImpl implements PatientDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public Patient savePatient(Patient patient) {
        session.beginTransaction();
        session.save(patient);
        session.getTransaction().commit();

        return patient;
    }

    @Override
    public Patient findByIdPatient(int id) {
        Patient patient = null;
        Query query = session.createQuery("from patient where id_patient = :id ");
        query.setParameter("id_patient", id);

        if (query.list().size() > 0) {
            patient = (Patient) query.list().get(0);
        }

        return patient;
    }

    @Override
    public Patient findByNamePatient(String name) {
        Patient patient = null;
        Query query = session.createQuery("from patient p where p.name like :name ");
        query.setParameter("name", name);

        if (query.list().size() > 0) {
            patient = (Patient) query.list().get(0);
        }

        return patient;
    }

    @Override
    public void updatePatient(Patient patient) {
        session.beginTransaction();
        session.update(patient);
        session.getTransaction().commit();
    }

    @Override
    public void deletePatient(Patient patient) {
        session.beginTransaction();
        session.delete(patient);
        session.getTransaction().commit();
    }

    @Override
    public List<Patient> findAllPatient() {
        List<Patient> patient = null;
        Query query = session.createQuery("from patient");

        if (query.list().size() > 0) {
            patient = (List<Patient>) query.list();
        }
        return patient;
    }

    @Override
    public PatientAppointment savePatientAppointment(PatientAppointment patientAppointment) {
        session.beginTransaction();
        session.save(patientAppointment);
        session.getTransaction().commit();

        return patientAppointment;
    }

    @Override
    public PatientAppointment findByIdPatientAppointment(int id) {
        PatientAppointment patientAppointment = null;
        Query query = session.createQuery("from appointment where id_appointment = :id ");
        query.setParameter("id_appointment", id);

        if (query.list().size() > 0) {
            patientAppointment = (PatientAppointment) query.list().get(0);
        }

        return patientAppointment;
    }

    @Override
    public void updatePatientAppointment(PatientAppointment patientAppointment) {
        session.beginTransaction();
        session.update(patientAppointment);
        session.getTransaction().commit();
    }

    @Override
    public void deletePatientAppointment(PatientAppointment patientAppointment) {
        session.beginTransaction();
        session.delete(patientAppointment);
        session.getTransaction().commit();
    }

    @Override
    public List<PatientAppointment> findAllPatientAppointment() {
        List<PatientAppointment> patientAppointment = null;
        Query query = session.createQuery("from appointment");

        if (query.list().size() > 0) {
            patientAppointment = (List<PatientAppointment>) query.list();
        }
        return patientAppointment;
    }
}
