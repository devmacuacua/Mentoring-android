package mz.org.csaude.mentoring.workSchedule.work;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.WorkerParameters;

import java.util.List;

import mz.org.csaude.mentoring.base.worker.BaseWorker;
import mz.org.csaude.mentoring.model.location.HealthFacility;
import mz.org.csaude.mentoring.workSchedule.rest.HealthFacilityRestService;
import mz.org.csaude.mentoring.workSchedule.rest.ProfessionalCategoryRestService;

public class HealthFacilityWorker extends BaseWorker<HealthFacility> {

    private HealthFacilityRestService healthFacilityRestService;
    private ProfessionalCategoryRestService professionalCategoryRestService;

    public HealthFacilityWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.healthFacilityRestService = new HealthFacilityRestService((Application) this.context.getApplicationContext());
        this.professionalCategoryRestService = new ProfessionalCategoryRestService((Application) this.context.getApplicationContext());
    }

    @Override
    protected void doOnStart() {

        this.healthFacilityRestService.restGetHealthFacility(this);
        this.professionalCategoryRestService.restGetProfessionalCategory();
    }

    @Override
    protected void doOnFinish() {

    }
    @Override
    protected void doSave(List<HealthFacility> recs) {

    }
}
